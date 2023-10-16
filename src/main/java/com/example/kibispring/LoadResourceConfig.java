package com.example.kibispring;

import java.util.ArrayList;
import java.util.TreeMap;

public class LoadResourceConfig {
  
  public static TreeMap<Double, String> loadCumulativeWeighetedWords() {
    ArrayList<String[]> csvArrayList = ResourceReader.csvAsArrayList("unigram_freq.txt",1);
    TreeMap<Double, String> cumulativeWeigthedWords = new TreeMap<Double, String>();

    long totalFrequency = 0;
    for(String[] wordFrequency : csvArrayList) {
      totalFrequency += Long.parseLong(wordFrequency[1]);
    }

    double previousWeight = 0;
    for(String[] wordFrequency : csvArrayList) {
      double weight = previousWeight + Long.parseLong(wordFrequency[1]) / (double) totalFrequency;
      cumulativeWeigthedWords.put(weight, wordFrequency[0]);
      previousWeight = weight;
    }

    return cumulativeWeigthedWords;
  }
}
