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
9. [References](#-references)  
10. [License](#-license)  

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

  

📄 Example Data:
