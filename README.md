# ⚙️ Machine Failure Prediction with Hadoop MapReduce  

[![Java](https://img.shields.io/badge/Java-17-orange?logo=java)](https://www.oracle.com/java/)  
[![Hadoop](https://img.shields.io/badge/Hadoop-3.3.6-blue?logo=apache)](https://hadoop.apache.org/)  
[![BigData](https://img.shields.io/badge/Big%20Data-IoT-green?logo=apache-spark)](https://hadoop.apache.org/)  
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)  

---

## 📑 Table of Contents
1. [Project Overview](#-project-overview)  
2. [Technologies Used](#-technologies-used)  
3. [Dataset Description](#-dataset-description)  
4. [Implementation Workflow](#-implementation-workflow)  
5. [Sample Output](#-sample-output)  
6. [Results & Conclusion](#-results--conclusion)  
7. [Future Enhancements](#-future-enhancements)  
8. [Contributors](#-contributors)  

---

## 📌 Project Overview  
This project implements a **Predictive Maintenance System** using **Hadoop MapReduce**.  
It analyzes **IoT sensor data** (temperature, vibration, pressure) from industrial machines to detect anomalies and predict failures **before breakdowns occur**.  
The solution helps industries **reduce downtime, lower repair costs, and improve efficiency**.  

---

## 🛠️ Technologies Used  
- **Java** (for MapReduce implementation)  
- **Apache Hadoop 3.3.6** (HDFS + YARN + MapReduce)  
- **IoT Sensor Data** (Temperature, Vibration, Pressure)  

---

## 📂 Dataset Description  
- **Machine ID**: Unique identifier  
- **Temperature (°C)**  
- **Vibration (units)**  
- **Pressure (psi)**  

**Thresholds for Failure Detection:**  
- Temperature > 75 °C  
- Vibration > 50 units  
- Pressure > 100 psi

---
MachineID Temperature Vibration Pressure
Machine1 80.5 45.2 110
Machine2 65.2 30.1 90
Machine3 85.0 60.5 120


---

###⚙️ Implementation Workflow  

## 1️⃣ Start Hadoop Services
start-dfs.sh
start-yarn.sh

---
## 2️⃣ Upload Dataset to HDFS

hdfs dfs -mkdir -p /satwik/predict/input
hdfs dfs -put data.csv /satwik/predict/input

---
## 3️⃣ Compile and Run MapReduce Program
# Compile
mkdir machine_classes
javac -classpath `hadoop classpath` -d machine_classes SensorDataMapper.java SensorDataReducer.java MachineFailurePrediction.java
# Create JAR
jar -cvf MachineFailurePrediction.jar -C machine_classes/ .
# Run Job
hadoop jar MachineFailurePrediction.jar MachineFailurePrediction /satwik/predict/input /satwik/predict/predict_output

---
## 4️⃣ View Results
hdfs dfs -cat /satwik/predict/predict_output/part-r-00000

---
## 📊 Sample Output
Machine1  Failure Expected: Temperature > 75, Vibration > 50
Machine3  Failure Expected: Pressure > 100
Machine7  Failure Expected: Temperature > 75

---
## ✅ Results & Conclusion
✔️ Processes large IoT datasets efficiently with Hadoop.
✔️ Detects machines at risk of failure before breakdown.
✔️ Improves operational reliability & scalability for Industry 4.0.

----
## 🚀 Future Enhancements
🔹 Real-Time Processing → Apache Spark / Kafka
🔹 Machine Learning Models → Adaptive anomaly detection
🔹 Visualization Dashboards → Monitor machine health

---
## 👨‍💻 Contributors
Meenugu Hani Satwik
Sureddy D B S N Rishi
Arjila Kasi
Andey Lokesh Naidu

