import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

y_data = [74.0, 65.1, 54.7, 49.0, 45.2, 43.6, 44.5, 43.3, 46.6, 42.8, 44.0, 44.2, 42.4, 46.2, 44.5, 43.3, 42.0, 37.6, 41.1, 41.5, 42.9, 36.2, 35.6, 37.2, 34.9, 38.3, 38.5, 38.1]
dataCnt = len(y_data)
x_data = list(range(dataCnt))

y_data = np.array(y_data)
x_data = np.array(x_data)

weight = np.sum((y_data-np.mean(y_data))*(x_data-np.mean(x_data)))/np.sum((x_data-np.mean(x_data))**2)
bias = np.mean(y_data) - weight*np.mean(x_data)

x_reg = np.arange(min(x_data) - 2, max(x_data) + 5, 1)
y_reg = weight * x_reg + bias

predict_y = weight * dataCnt + bias

print("Predicted Price : " + str(round(predict_y, 1)) + " KRW")

plt.plot(x_reg, y_reg, color = 'r')
plt.scatter(x_data, y_data)
plt.scatter(dataCnt, predict_y, color = 'r')
plt.xlabel("Days")
plt.ylabel("Prices (ATH)")
plt.show()