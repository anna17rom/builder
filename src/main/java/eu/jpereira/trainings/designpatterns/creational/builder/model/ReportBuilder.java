package eu.jpereira.trainings.designpatterns.creational.builder.model;

abstract class ReportBuilder {
 
protected SaleEntry saleEntry = new SaleEntry();
protected Report report;
    public Report getReport() {
        return report;
    }

    public void createNewReport() {
        report = new Report();
    }

   public abstract void buildReport();
    public abstract void buildCustomer(String name, String phone);
    public abstract void printCustomer();
    public abstract void buildItem(String name, int quantity, double unitPrice);
    public abstract void printItems();
}
