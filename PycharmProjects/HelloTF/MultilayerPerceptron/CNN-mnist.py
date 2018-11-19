#!/usr/bin/env pytho      
# -*- coding: utf-8 -*-
# @Time    : 2018/11/16 3:16 PM
# @Author  : YangShuo

from tensorflow.examples.tutorials.mnist import input_data
import tensorflow as tf
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
sess = tf.InteractiveSession

'''
设置初始化函数
'''
def weight_variable(shape):
    initial = tf.truncated_normal(shape, stddev=0.1)  # 产生截断的标准差为0，1的正态分布的噪音
    return tf.Variable(initial)

def bias_variable(shape):
    initial = tf.constant(0.1, shape=shape)
    return tf.Variable(initial)

'''
卷积和池化
'''
def conv2d(x, W):
    # strides表示卷积模板移动的步长，都是1表示会不遗漏的划过图片的每一个点，padding表示便捷的处理方式
    return tf.nn.conv2d(x, W, strides=[1, 1, 1, 1], padding='SAME')

def max_pool_2x2(x):

    return tf.nn.max_pool(x, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding='SAME')

'''
输入输出定义
'''
x = tf.placeholder(tf.float32, [None, 784])
y_ = tf.placeholder(tf.float32, [None, 10])  # 真实label

x_image = tf.reshape(x, [-1, 28, 28, 1])  # tensor变形函数  -1表示数量不确定

'''
第一个卷积层     首先进行参数初始化，使用conv2d进行卷积操作，然后用relu激活函数进行非线性处理，最后使用池化函数进行池化
'''
W_conv1 = weight_variable(([5, 5, 1, 32]))
b_conv1 = bias_variable(([32]))
h_conv1 = tf.nn.relu(conv2d(x_image, W_conv1) + b_conv1)
h_pool1 = max_pool_2x2(h_conv1)

'''
第二个卷积层，卷积核变为64 其他不变
'''
W_conv2 = weight_variable(([5, 5, 1, 64]))
b_conv2 = bias_variable(([64]))
h_conv2 = tf.nn.relu(conv2d(x_image, W_conv2) + b_conv2)
h_pool2 = max_pool_2x2(h_conv2)

'''经过两次2*2池化，尺寸变为四分之一，第二个卷积层的卷积核为64，所以想现在是 7*7*64'''

W_fc1 = weight_variable(([7*7*64, 1024]))  # 设置隐含层输入节点和隐含节点数
b_fc1 = bias_variable([1024])
h_pool2_flat = tf.reshape(h_pool2, [-1, 7*7*64])
h_fc1 = tf.nn.relu(tf.matmul(h_pool2_flat, W_fc1) + b_fc1)

'''
dropout层 
'''
keep_prob = tf.placeholder(tf.float32)
h_fc1_drop = tf.nn.dropout(h_fc1,keep_prob)

'''
连接softmax层
'''
W_fc2 =weight_variable([1024, 10])
b_fc2 = bias_variable([10])
y_conv=tf.nn.softmax(tf.matmul(h_fc1_drop, W_fc2) + b_fc2)

'''
定义损失函数 
'''
cross_entropy = tf.reduce_mean(-tf.reduce_sum(y_ * tf.log(y_conv), reduction_indices=[1]))
train_step = tf.train.AdamOptimizer(1e-4).minimize(cross_entropy)

'''

'''


















