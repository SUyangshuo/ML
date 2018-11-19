#!/usr/bin/env pytho      
# -*- coding: utf-8 -*-
# @Time    : 2018/11/15 8:32 PM
# @Author  : YangShuo
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

from tensorflow.examples.tutorials.mnist import input_data

import tensorflow as tf
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
sess = tf.InteractiveSession()

# 输入节点
in_units = 784
h1_units = 300
# 将输入输出节点初始化为阶段的正态分布，标准差为0.1
W1 = tf.Variable(tf.truncated_normal([in_units, h1_units], stddev=0.1))
b1 = tf.Variable(tf.zeros([h1_units]))
W2 = tf.Variable(tf.zeros([h1_units, 10]))
b2 = tf.Variable(tf.zeros([10]))

# 定义x的占位符
x = tf.placeholder(tf.float32, [None, in_units])
# dropout的占位符
keep_prob = tf.placeholder(tf.float32)  # 训练时应该小于1 预测时应该等于1

'''
定义模型结构
'''
# 隐含层
hidden1 = tf.nn.relu(tf.matmul(x, W1) + b1)  # 设置一个激活函数为relu的激活层
hidden1_drop = tf.nn.dropout(hidden1, keep_prob)
y = tf.nn.softmax(tf.matmul(hidden1_drop, W2) + b2)

'''
定义损失函数，选择优化器有优化loss
'''
y_ = tf.placeholder(tf.float32, [None, 10])
cross_entropy = tf.reduce_mean(-tf.reduce_sum(y_ * tf.log(y), reduction_indices=[1]))  # 损失函数是交叉熵
train_step = tf.train.AdamOptimizer(0.3).minimize(cross_entropy)

'''
训练步骤
'''
sess.run(tf.global_variables_initializer())
for i in range(3000):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    train_step.run({x: batch_xs, y_: batch_ys, keep_prob: 0.75})


'''
准确度评估
'''
correct_prediction = tf.equal(tf.arg_max(y, 1), tf.arg_max(y_, 1))
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
print(accuracy.eval({x: mnist.test.images, y_: mnist.test.labels, keep_prob: 1.0}))























