import java.util.Scanner;

class lifeInsurance {
    private String insuranceNo;
    private String insuranceName;
    private double amountCovered;
    private float benefitpercent;
    private int policyTerm;


    public lifeInsurance(String insuranceNo, String insuranceName, double amountCovered) {
        this.insuranceNo = insuranceNo;
        this.insuranceName = insuranceName;
        this.amountCovered = amountCovered;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }
    public String getInsuranceName() {
        return insuranceName;
    }
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    public double getAmountCovered() {
        return amountCovered;
    }
    public void setAmountCovered(double amountCovered) {
        this.amountCovered = amountCovered;
    }
    public double calcPremium(){
       double premium = amountCovered-((amountCovered/benefitpercent)*100))/policyTerm;
        return 0.0;
    }
}

class motorInsurance extends lifeInsurance {
    private double IDV;
    private float depPercent;

    public motorInsurance(String insuranceNo, String insuranceName, double amountCovered, float depPercent) {
        super(insuranceNo, insuranceName, amountCovered);
        this.depPercent = depPercent;
    }
    public double getIDV() {
        return IDV;
    }
    public void setIDV(double IDV) {
        this.IDV = IDV;
    }
    public float getDepPercent() {
        return depPercent;
    }
    public void setDepPercent(float depPercent) {
        this.depPercent = depPercent;
    }
    public double calcPremium(){
        IDV=getAmountCovered()-((getAmountCovered()*depPercent)/100);
        double premium=(3.0/100)*IDV;
        return premium;
    }
}
public class insuranceCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Insurance number: ");
        String insuranceNo = sc.nextLine();
        System.out.println("Enter the Insurance Name: ");
        String insuranceName = sc.nextLine();
        System.out.println("Enter the Amount Covered: ");
        double amountCovered = sc.nextDouble();
        System.out.println("Choose insurance option [1 for Life Insurance and 2 for Motor Insurance] :");
        int option = sc.nextInt();
        double premium;
        if (option == 1) {
            System.out.println("Enter the policy term: ");
            int policyTerm = sc.nextInt();
            System.out.println("Enter benefit percent: ");
            double percentBenefit = sc.nextDouble();
            lifeInsurance lifeInsurance = new lifeInsurance(insuranceNo, insuranceName,amountCovered);// policyTerm,percentBenefit);
            premium = addPolicy(lifeInsurance);
        } else if (option == 2) {
            System.out.println("Enter the Depreciation percent: ");
            float depPercent = sc.nextFloat();
            motorInsurance motorInsurance = new motorInsurance(insuranceNo, insuranceName, amountCovered, depPercent);
            premium = addPolicy(motorInsurance);
        } else {
            System.out.println("Invalid Option ");
            return;
        }
        System.out.println("Caclulated Premuim is :" + premium);
    }

    public static double addPolicy(lifeInsurance insurance) {
     return insurance.calcPremium();
    }
}
