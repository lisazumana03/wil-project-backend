package za.co.lzinc.heriplay.dto.quiz;

import java.io.Serializable;

public class SubjectDTO implements Serializable {
    private int subjectId;
    private String subjectName;
    private String subjectCode;
    private String subjectDescription;

    public SubjectDTO(int subjectId, String subjectName, String subjectCode, String subjectDescription) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.subjectDescription = subjectDescription;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", subjectDescription='" + subjectDescription + '\'' +
                '}';
    }

    public static class Builder{
        private int subjectId;
        private String subjectName;
        private String subjectCode;
        private String subjectDescription;

        public Builder setSubjectId(int subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setSubjectDescription(String subjectDescription) {
            this.subjectDescription = subjectDescription;
            return this;
        }

        public SubjectDTO build(){
            return new SubjectDTO(subjectId,subjectName,subjectCode,subjectDescription);
        }
    }
}
