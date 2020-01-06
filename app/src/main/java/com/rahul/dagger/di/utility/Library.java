package com.rahul.dagger.di.utility;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Library {

    @SerializedName("bookdata")
    private List<LibraryData> bookdata;

    @SerializedName("student_book_array")
    private List<LibraryData> student_book_array;

    @SerializedName("library_data")
    private List<LibraryData> library_data;

    public List<LibraryData> getStudent_book_array() {
        return student_book_array;
    }

    public void setStudent_book_array(List<LibraryData> student_book_array) {
        this.student_book_array = student_book_array;
    }

    public List<LibraryData> getBookdata() {
        return bookdata;
    }

    public List<LibraryData> getLibrary_data() {
        return library_data;
    }
    public void setLibrary_data(List<LibraryData> library_data) {
        this.library_data = library_data;
    }

    public void setBookdata(List<LibraryData> bookdata) {
        this.bookdata = bookdata;
    }


    public static class LibraryData{

        public LibraryData(){}

        @SerializedName("bookname")
        private String bookname;

        @SerializedName("issuedate")
        private String issuedate;

        @SerializedName("duedate")
        private String duedate;

        @SerializedName("returndate")
        private String returndate;

        @SerializedName("accessionno")
        private String accessionno;

        @SerializedName("count")
        private String count;

        @SerializedName("label")
        private String label;

        @SerializedName("bookfine")
        private String bookfine;



        public String getBookfine() {
            return bookfine;
        }

        public void setBookfine(String bookfine) {
            this.bookfine = bookfine;
        }



        public String getBookname() {
            return bookname;
        }

        public void setBookname(String bookname) {
            this.bookname = bookname;
        }

        public String getIssuedate() {
            return issuedate;
        }

        public void setIssuedate(String issuedate) {
            this.issuedate = issuedate;
        }

        public String getDuedate() {
            return duedate;
        }

        public void setDuedate(String duedate) {
            this.duedate = duedate;
        }

        public String getReturndate() {
            return returndate;
        }

        public void setReturndate(String returndate) {
            this.returndate = returndate;
        }

        public String getAccessionno() {
            return accessionno;
        }

        public void setAccessionno(String accessionno) {
            this.accessionno = accessionno;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

    }
}
