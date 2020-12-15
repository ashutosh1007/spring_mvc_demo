package com.aditi.model;

public class LoanApplication {

    private int user_id;
    private String company_name;
    private Float monthly_income;
    private int work_experience;
    private String type_of_emp;
    private int existing_emi;

    private int loan_amount;
    private int loan_tenure;
    private int roi;
    private int emi;
    private String account_type;
    private int processing_fee;



    private String vehicle_company;
    private String vehicle_model;
    private int ex_showroom_price;
    private int on_road_price;

    public LoanApplication(){

    }

    public LoanApplication(int user_id, String company_name, Float monthly_income, int work_experience, String type_of_emp, int existing_emi, int loan_amount, int loan_tenure, int roi, int emi, String account_type, int processing_fee, String vehicle_company, String vehicle_model, int ex_showroom_price, int on_road_price) {
        this.user_id = user_id;
        this.company_name = company_name;
        this.monthly_income = monthly_income;
        this.work_experience = work_experience;
        this.type_of_emp = type_of_emp;
        this.existing_emi = existing_emi;
        this.loan_amount = loan_amount;
        this.loan_tenure = loan_tenure;
        this.roi = roi;
        this.emi = emi;
        this.account_type = account_type;
        this.processing_fee = processing_fee;
        this.vehicle_company = vehicle_company;
        this.vehicle_model = vehicle_model;
        this.ex_showroom_price = ex_showroom_price;
        this.on_road_price = on_road_price;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Float getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(Float monthly_income) {
        this.monthly_income = monthly_income;
    }

    public int getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

    public String getType_of_emp() {
        return type_of_emp;
    }

    public void setType_of_emp(String type_of_emp) {
        this.type_of_emp = type_of_emp;
    }

    public int getExisting_emi() {
        return existing_emi;
    }

    public void setExisting_emi(int existing_emi) {
        this.existing_emi = existing_emi;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getLoan_tenure() {
        return loan_tenure;
    }

    public void setLoan_tenure(int loan_tenure) {
        this.loan_tenure = loan_tenure;
    }

    public int getRoi() {
        return roi;
    }

    public void setRoi(int roi) {
        this.roi = roi;
    }

    public int getEmi() {
        return emi;
    }

    public void setEmi(int emi) {
        this.emi = emi;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public int getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(int processing_fee) {
        this.processing_fee = processing_fee;
    }

    public String getVehicle_company() {
        return vehicle_company;
    }

    public void setVehicle_company(String vehicle_company) {
        this.vehicle_company = vehicle_company;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public int getEx_showroom_price() {
        return ex_showroom_price;
    }

    public void setEx_showroom_price(int ex_showroom_price) {
        this.ex_showroom_price = ex_showroom_price;
    }

    public int getOn_road_price() {
        return on_road_price;
    }

    public void setOn_road_price(int on_road_price) {
        this.on_road_price = on_road_price;
    }

    public String getCompany_name() {
        return company_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "user_id=" + user_id +
                ", company_name='" + company_name + '\'' +
                ", monthly_income=" + monthly_income +
                ", work_experience=" + work_experience +
                ", type_of_emp='" + type_of_emp + '\'' +
                ", existing_emi=" + existing_emi +
                ", loan_amount=" + loan_amount +
                ", loan_tenure=" + loan_tenure +
                ", roi=" + roi +
                ", emi=" + emi +
                ", account_type='" + account_type + '\'' +
                ", processing_fee=" + processing_fee +
                ", vehicle_company='" + vehicle_company + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", ex_showroom_price=" + ex_showroom_price +
                ", on_road_price=" + on_road_price +
                '}';
    }
}
