package gaming.pe.Service;

import gaming.pe.Entity.Kardex;
import gaming.pe.Repository.KardexRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceReport {

    @Autowired
    KardexRepository repository;
    public String exportReport(String reportFormat) throws Exception {
        String path = "C:\\Users\\Usuario\\Downloads\\Jasper\\Reportes";
        List<Kardex> repositoryAll = repository.findAll();

        File file;
        if (reportFormat.equalsIgnoreCase("pdf")) {
            file = ResourceUtils.getFile("classpath:kardex_pdf.jrxml");
        } else if (reportFormat.equalsIgnoreCase("xls")) {
            file = ResourceUtils.getFile("classpath:kardex_xls.jrxml");
        } else {
            file = ResourceUtils.getFile("classpath:kardex_html.jrxml");
        }

        JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(repositoryAll);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created By", "Learn Code With Sankalp");

        JasperPrint print = JasperFillManager.fillReport(jr, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(print, path + "\\kardex.html");
        }

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(print, path + "\\kardex.pdf");
        }

        if (reportFormat.equalsIgnoreCase("xls")) {
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setExporterInput(new SimpleExporterInput(print));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path + "\\kardex.xls"));

            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
            configuration.setOnePagePerSheet(true);
            configuration.setDetectCellType(true);
            exporter.setConfiguration(configuration);

            exporter.exportReport();
        }

        return "File Created At Path: " + path;
    }
}