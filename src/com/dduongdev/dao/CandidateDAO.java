package com.dduongdev.dao;

import com.dduongdev.entities.Candidate;

import java.sql.SQLException;

public interface CandidateDAO {
    /**
     * Call a stored procedure to save a candidate to database.
     *
     * @method saveCandidate
     * @param Candidate
     * @return boolean
     * @throws SQLException
     */
    public boolean saveCandidate(Candidate candidate) throws SQLException;
}
