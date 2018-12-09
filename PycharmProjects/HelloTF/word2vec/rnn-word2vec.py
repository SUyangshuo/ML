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
