package com.air.pollution.util;

public class AQICategoryBreakPointUtil {

    public static String findCOCategory(double range) {
        if (range <= 1.0) {
            return "Good";
        } else if (range <= 2.0) {
            return "Satisfactory";
        } else if (range <= 10.0) {
            return "Moderate";
        } else if (range <= 17.0) {
            return "Poor";
        } else if (range <= 34.0) {
            return "Severe";
        } else {
            return "Hazardous";
        }
    }

    public static String findO3Category(double range) {
        if (range <= 50) {
            return "Good";
        } else if (range <= 100) {
            return "Satisfactory";
        } else if (range <= 168) {
            return "Moderate";
        } else if (range <= 208) {
            return "Poor";
        } else if (range <= 748) {
            return "Severe";
        } else {
            return "Hazardous";
        }
    }

    public static String findSO2Category(double range) {
        if (range <= 40) {
            return "Good";
        } else if (range <= 80) {
            return "Satisfactory";
        } else if (range <= 380) {
            return "Moderate";
        } else if (range <= 800) {
            return "Poor";
        } else if (range <= 1600) {
            return "Severe";
        } else {
            return "Hazardous";
        }
    }


}
