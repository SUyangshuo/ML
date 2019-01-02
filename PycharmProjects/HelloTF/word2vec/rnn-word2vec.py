#!/usr/bin/env pytho      
# -*- coding: utf-8 -*-
# @Time    : 2018/12/7 3:32 PM
# @Author  : YangShuo

import collections
import math
import os
import random
import zipfile
import numpy as np
import urllib
import tensorflow as tf

url = 'http://mattmahoney.net/dc/'
'''
下载文本数据
'''
def maybe_download(filename,expected_bytes):
    if not os.path.exists(filename):
        filename, _ = urllib.request.urlretrieve(url + filename, filename)
    statinfo = os.stat(filename)
    if statinfo.st_size == expected_bytes:
        print('Found and verified',filename)
    else:
        print(statinfo.st_size)
        raise Exception(
            'Failed to verify'+ filename + '.Can you get to it with a browser?'
        )
    return filename

filename = maybe_download('text8.zip', 31344016)

'''
解压文件
'''

def read_data(filename):
    with zipfile.ZipFile(filename) as f:
        data = tf.compat.as_str(f.read(f.namelist()[0])).split()
    return data

word = read_data(filename)
print('Data size', len(word))

'''
创建vocabulary词汇表
'''
## 保存top50000的词汇
vocabulary_size = 50000

def build_dataset(words):
    count = [['UNK', -1]]
    # collections.Counter取出单词列表中的单词频数，most_common取top50000中的作为一个词汇表
    count.extend(collections.Counter(words).most_common(vocabulary_size - 1))
    dictionary = dict()  # 创建一个空字典

    for word, _ in count:
        dictionary[word] = len(dictionary)  # 查看该词是否在字典表中
    data = list()  # 元组(元组里的数据不能修改 元组是括号) 转化为列表(列表是中括号 元素可以修改)
    unk_count = 0
    for word in words:
        if word in dictionary:
            index = dictionary[word]
        else:
            index = 0
            unk_count += 1
        data.append(index)

    count[0][1] = unk_count   #top50000以后的单词的数量
    #  zip方法 是把两个迭代器一一对应 产出一个元组，再使用list方法可以转化为列表 dict是转化为一个字典，存储key和valueas
    reverse_dictionary = dict(zip(dictionary.values(), dictionary.keys()))
    return data, count, dictionary, reverse_dictionary
    data, count, dictionary, reverse_dictionary = build_dataset(words)

# 删除原始单词列表

data_index = 0

# batch大小--每个单词生成多少个样本(不能大于窗口值)---最远可以联系到的距离
# 并且batch——size必须是num_skips的整数倍
def generate_batch(batch_size, num_skips, skip_window):
    global data_index
    assert batch_size % num_skips == 0
    assert num_skips <= 2 * skip_window
    batch = np.ndarray(shape=(batch_size), dtype=np.int32)
    labels = np.ndarray(shape=(batch_size,1), dtype=np.int32)
    span = 2* skip_window + 1
    buffer = collections.deque(maxlen=span)

    for _ in range(span):
        buffer.append(data[data_index])
        data_index = (data_index + 1) % len(data)
    for i in range(batch_size // num_skips):
        target = skip_window
        targets_to_avoid = [skip_window]
        for j in range(num_skips):
            while target in targets_to_avoid:
                target = random.randint(0, span - 1)
            targets_to_avoid.append(target)
            batch[i * num_skips + j] = buffer[skip_window]
            labels[i * num_skips + j, 0] = buffer[target]
        buffer.append(data_index + 1) % len(data)
    return batch, labels






