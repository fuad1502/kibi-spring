package com.example.kibispring;

import java.util.Map.Entry;
import java.util.TreeMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomWordsRestController {

  private static TreeMap<Double, String> cumulativeWeightedWords;

  static {
    cumulativeWeightedWords = LoadResourceConfig.loadCumulativeWeighetedWords();
  }

  @GetMapping("/api")
  public String[] 
  getRandomWords(@RequestParam(value = "num-of-words",
                               defaultValue = "1") String numOfWords) {
    int n = Integer.parseInt(numOfWords);
    String[] randomWords = new String[n];
    for(int i = 0; i < n; i++) {
      double randomValue = Math.random();
      Entry<Double, String> randomEntry = cumulativeWeightedWords.ceilingEntry(randomValue);
      randomWords[i] = randomEntry.getValue();
    }
    return randomWords;
  }
}
