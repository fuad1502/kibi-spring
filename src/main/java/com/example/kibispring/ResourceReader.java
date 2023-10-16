package com.example.kibispring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.springframework.core.io.ClassPathResource;

public class ResourceReader {

  public static ArrayList<String[]> csvAsArrayList(String fileName,
                                                   int lineStart) {
    ClassPathResource resource = new ClassPathResource(fileName);
    ArrayList<String[]> stringArrayList = new ArrayList<String[]>();

    try {
      InputStreamReader inputStreamReader =
          new InputStreamReader(resource.getInputStream());
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      // ignore lines until lineStart
      for (int i = 0; i < lineStart; i++) {
        bufferedReader.readLine();
      }

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringArrayList.add(line.split(","));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return stringArrayList;
  }
}
