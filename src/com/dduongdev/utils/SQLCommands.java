package com.dduongdev.utils;

public class SQLCommands {
    public static final String EXPERIENCE_CANDIDATE_SAVE_QUERY = "{CALL usp_AddExperienceCandidate(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String FRESHER_CANDIDATE_SAVE_QUERY = "{CALL usp_AddFresherCandidate(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public static final String INTERN_CANDIDATE_SAVE_QUERY = "{CALL usp_AddInternCandidate(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
}
