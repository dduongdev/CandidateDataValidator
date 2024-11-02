package com.dduongdev.entities.filehandlers;

import com.dduongdev.utils.Constants;
import com.dduongdev.utils.IncorrectDataTypes;

import java.io.*;
import java.util.*;

public class CandidateFileHandler {
    private FileReader fReader = null;
    private BufferedReader bfReader = null;
    private BufferedWriter bfWriter = null;

    public List<String> getAll() throws IOException {
        List<String> result = new ArrayList<>();

        fReader = new FileReader(new File(Constants.FILE_INPUT_PATH));
        bfReader = new BufferedReader(fReader);

        String data = bfReader.readLine();
        while(data != null) {
            result.add(data);
            data = bfReader.readLine();
        }
        bfReader.close();

        return result;
    }

    public void exportCheckDataCandidateResult(LinkedHashMap<Integer, Set<IncorrectDataTypes>> checkDataResults) throws IOException {
        try {
            bfWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.FILE_OUTPUT_PATH), "UTF-8"));
            Iterator<Map.Entry<Integer, Set<IncorrectDataTypes>>> iterator = checkDataResults.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry<Integer, Set<IncorrectDataTypes>> data = iterator.next();

                if(data.getValue().contains(IncorrectDataTypes.BRITHDATE_FORMAT)) {
                    bfWriter.write("Dòng " + data.getKey() + ": Sai định dạng ngày tháng năm sinh");
                    bfWriter.newLine();
                }

                if(data.getValue().contains(IncorrectDataTypes.PHONE_FORMAT)) {
                    bfWriter.write("Dòng " + data.getKey() + ": Sai định dạng số điện thoại");
                    bfWriter.newLine();
                }

                if(data.getValue().contains(IncorrectDataTypes.EMAIL_FORMAT)) {
                    bfWriter.write("Dòng " + data.getKey() + ": Sai định dạng email");
                    bfWriter.newLine();
                }

                if(data.getValue().contains(IncorrectDataTypes.YOE)) {
                    bfWriter.write("Dòng " + data.getKey() + ": Sai định dạng số năm kinh nghiệm");
                    bfWriter.newLine();
                }

                if(data.getValue().contains(IncorrectDataTypes.EXCESS_DATA)) {
                    bfWriter.write("Dòng " + data.getKey() + ": Thừa dữ liệu");
                    bfWriter.newLine();
                }
            }
        }
        finally {
            try {
                if(bfWriter != null) {
                    bfWriter.close();
                }
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
