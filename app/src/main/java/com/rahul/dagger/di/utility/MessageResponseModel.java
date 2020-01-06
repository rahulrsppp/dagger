package com.rahul.dagger.di.utility;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 4/30/2018.
 */
public class MessageResponseModel {

    @SerializedName("comunicationdata")
    private List<Message> comunicationdata;

    @SerializedName("sms_array")
    private List<Message> sms_array;

    @SerializedName("mymessage_array")
    private List<Message> mymessage_array;

    @SerializedName("alumni_outbox_array")
    private List<Message> alumni_outbox_array;

    public List<Message> getCommunicationData() {
        return comunicationdata;
    }

    public void setCommunicationData(List<Message> comunicationdata) {
        this.comunicationdata = comunicationdata;
    }

    public List<Message> getSms_array() {
        return sms_array;
    }

    public void setSms_array(List<Message> sms_array) {
        this.sms_array = sms_array;
    }

    public List<Message> getMymessage_array() {
        return mymessage_array;
    }

    public void setMymessage_array(List<Message> mymessage_array) {
        this.mymessage_array = mymessage_array;
    }

    public List<Message> getAlumni_outbox_array() {
        return alumni_outbox_array;
    }

    public void setAlumni_outbox_array(List<Message> alumni_outbox_array) {
        this.alumni_outbox_array = alumni_outbox_array;
    }

    public static class Message {


        @SerializedName("message")
        private String message;

        @SerializedName("filepath")
        private String filepath;

        @SerializedName("subject")
        private String subject;

        @SerializedName("filename")
        private String filename;

        @SerializedName("statusid")
        private int statusid;

        @SerializedName("communicationid")
        private int communicationid;

        @SerializedName("from")
        private String from;

        @SerializedName("date")
        private String date;

        @SerializedName("from_img_path")
        private String from_img_path;

        @SerializedName("creationdatetime")
        private String creationdatetime;

        @SerializedName("communicationstudentid")
        private String communicationstudentid;

        @SerializedName("communicationteacherid")
        private String communicationteacherid;

        @SerializedName("employeename")
        private String employeename;

        @SerializedName("message_date")
        private String message_date;

        @SerializedName("mobileno")
        private String mobileno;

        @SerializedName("from_name")
        private String from_name;

        @SerializedName("from_code")
        private String from_code;

        @SerializedName("message_to")
        private String message_to;

        @SerializedName("type")
        private String type;

        @SerializedName("no_reply")
        private String no_reply;

        //ALumni data for inbox
        @SerializedName("alumnibatchid")
        private String alumnibatchid;

        @SerializedName("createdby")
        private String createdby;

        @SerializedName("from_alumni_id")
        private String from_alumni_id;

        @SerializedName("messagedate")
        private String messagedate;

        @SerializedName("status")
        private String status;

        @SerializedName("to_alumni_id")
        private String to_alumni_id;
    }


}
