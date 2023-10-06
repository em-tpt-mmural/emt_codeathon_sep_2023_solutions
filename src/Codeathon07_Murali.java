package src;

import java.io.File;
import java.util.*;

public class Codeathon07_Murali {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter valid Windows directory path: ");
            String inputDirectoryPath = sc.nextLine();
            File input= new File(inputDirectoryPath);
            if (!input.exists() || !input.isDirectory()) {
                System.out.println("Directory Not Found on the Filesystem");
            } else {
                Map<String, List<String>> fileMap = new TreeMap<>();
                directory(input, fileMap);
                for (Map.Entry<String, List<String>> main : fileMap.entrySet()) {
                    System.out.print(main.getKey());
                    List<String> files = main.getValue();
                    if (files.isEmpty()) {
                        System.out.println();
                    } else {
                        System.out.print("  ");
                        for (int i = 0; i < files.size(); i++) {
                            System.out.print(files.get(i));
                            if (i < files.size() - 1) {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        private static void directory(File directory, Map<String, List<String>> fileMap) {
            File[] f = directory.listFiles();

            if (f != null) {
                List<String> txtAndExeFiles = new ArrayList<>();
                for (File file : f) {
                    if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".exe"))) {
                        txtAndExeFiles.add(file.getName());
                    }
                }
                fileMap.put(directory.getAbsolutePath(), txtAndExeFiles);
                for (File subDirectory : f) {
                    if (subDirectory.isDirectory()) {
                        directory(subDirectory, fileMap);
                    }
                }
            }
        }
    }



