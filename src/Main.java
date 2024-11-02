import com.dduongdev.dao.CandidateDAO;
import com.dduongdev.dao.ExperienceCandidateDAOImpl;
import com.dduongdev.dao.FresherCandidateDAOImpl;
import com.dduongdev.dao.InternCandidateDAOImpl;
import com.dduongdev.entities.exceptions.IncorrectDataFormatException;
import com.dduongdev.entities.filehandlers.CandidateFileHandler;
import com.dduongdev.services.CandidateService;
import com.dduongdev.services.ExperienceCandidateService;
import com.dduongdev.services.FresherCandidateService;
import com.dduongdev.services.InternCandidateService;
import com.dduongdev.utils.IncorrectDataTypes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Main {
    private static CandidateFileHandler candidateFileHandle = new CandidateFileHandler();
    private static CandidateService experienceCandidateService = new ExperienceCandidateService();
    private static CandidateService fresherCandidateService = new FresherCandidateService();
    private static CandidateService internCandidateService = new InternCandidateService();
    private static CandidateDAO experienceCandidateDAO = new ExperienceCandidateDAOImpl();
    private static CandidateDAO fresherCandidateDAO = new FresherCandidateDAOImpl();
    private static CandidateDAO internCandidateDAO = new InternCandidateDAOImpl();

    public static void main(String[] args) {
        LinkedHashMap<Integer, Set<IncorrectDataTypes>> checkDataResults = new LinkedHashMap<Integer, Set<IncorrectDataTypes>>();
        try {
            List<String> candidateDatas = candidateFileHandle.getAll();
            for(int i = 0; i<candidateDatas.size(); i++) {
                String data = candidateDatas.get(i);
                String[] ss = data.split(",");
                int candidateType = Integer.parseInt(ss[0]);
                Set<IncorrectDataTypes> checkResult = null;
                switch (candidateType) {
                    case 1:
                        checkResult = experienceCandidateService.isValidCandidateData(data);
                        if(checkResult.isEmpty()) {
                            experienceCandidateDAO.saveCandidate(experienceCandidateService.createCandidate(data));
                        }
                        else {
                            checkDataResults.put(i + 1, checkResult);
                        }
                        break;
                    case 2:
                        checkResult = fresherCandidateService.isValidCandidateData(data);
                        if(checkResult.isEmpty()) {
                            fresherCandidateDAO.saveCandidate(fresherCandidateService.createCandidate(data));
                        }
                        else {
                            checkDataResults.put(i + 1, checkResult);
                        }
                        break;
                    case 3:
                        checkResult = internCandidateService.isValidCandidateData(data);
                        if(checkResult.isEmpty()) {
                            internCandidateDAO.saveCandidate(internCandidateService.createCandidate(data));
                        }
                        else {
                            checkDataResults.put(i + 1, checkResult);
                        }
                    default:
                        break;
                }
            }

            candidateFileHandle.exportCheckDataCandidateResult(checkDataResults);
        } catch (IOException | SQLException | IncorrectDataFormatException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }
}