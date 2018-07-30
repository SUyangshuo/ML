import tensorflow as tf
import input_data
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
# 设置占位符
x = tf.placeholder("float", [None, 784])
W = tf.Variable(tf.zeros([784,10]))
b = tf.Variable(tf.zeros([10]))


y = tf.nn.softmax(tf.matmul(x,W) + b)
# 为了计算交叉熵，我们首先需要添加一个新的占位符用于输入正确值：
y_ = tf.placeholder("float", [None,10])
# 计算交叉熵
cross_entropy = -tf.reduce_sum(y_*tf.log(y))
# 设置梯度下降的学习率
train_step = tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)
# 初始化创建变量
init = tf.initialize_all_variables()
# 设置一个session 启动我们的模型  初始化变量
sess = tf.Session()
sess.run(init)
# 循环训练模型
for i in range(1000):
  batch_xs, batch_ys = mnist.train.next_batch(100)
  sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})

# 模型评估
correct_prediction = tf.equal(tf.argmax(y,1), tf.argmax(y_,1))

accuracy = tf.reduce_mean(tf.cast(correct_prediction, "float"))

print(sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
