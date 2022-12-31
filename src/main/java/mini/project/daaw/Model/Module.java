package mini.project.daaw.Model;

public class Module {
    private String moduleName;
    private String week;
    private String type;
    private String file;
    private String pdfName;
    private String period;

    public Module(String moduleName, String week, String type, String file, String pdfName, String period) {
        this.moduleName = moduleName;
        this.week = week;
        this.type = type;
        this.file = file;
        this.pdfName = pdfName;
        this.period = period;
    }

    public Module() {
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getWeek() {
        return week;
    }

    public String getType() {
        return type;
    }

    public String getFile() {
        return file;
    }

    public String getPdfName() {
        return pdfName;
    }

    public String getPeriod() {return period; }

    ///setters

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
