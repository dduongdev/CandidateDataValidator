package com.dduongdev.dao;

import com.dduongdev.entities.Candidate;
import com.dduongdev.entities.InternCandidate;
import com.dduongdev.utils.DBUtils;
import com.dduongdev.utils.SQLCommands;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class InternCandidateDAOImpl implements CandidateDAO {
    private Connection conn = null;
    private CallableStatement caStatement = null;

    @Override
    public boolean saveCandidate(Candidate candidate) throws SQLException {
        boolean saveStatus = true;
        try {
            conn = DBUtils.getInstance().getConnection();
            caStatement = conn.prepareCall(SQLCommands.INTERN_CANDIDATE_SAVE_QUERY);
            caStatement.setInt(1, candidate.hashCode());
            caStatement.setString(2, candidate.getName());
            caStatement.setString(3, candidate.getBirthdate());
            caStatement.setString(4, candidate.getAddress());
            caStatement.setString(5, candidate.getHometown());
            caStatement.setString(6, candidate.getPhone());
            caStatement.setString(7, candidate.getEmail());
            caStatement.setString(8, ((InternCandidate) candidate).getMajorStudying());
            caStatement.setInt(9, ((InternCandidate) candidate).getCurrentSemester());
            caStatement.setString(10, ((InternCandidate) candidate).getSchoolName());
            caStatement.setString(11, ((InternCandidate) candidate).getExpectedGraduationDate());
            caStatement.registerOutParameter(12, Types.BIT);
            caStatement.execute();
            saveStatus = caStatement.getBoolean(12);
        }
        finally {
            try {
                if(caStatement != null)
                    caStatement.close();
                if(conn != null)
                    conn.close();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return saveStatus;
    }
}
