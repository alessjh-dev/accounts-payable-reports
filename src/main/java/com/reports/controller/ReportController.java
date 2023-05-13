package com.reports.controller;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private static final String PROVIDERS_REPORT = "src/main/resources/reports/Providers.jasper";
    private static final String REQUEST_REPORT = "src/main/resources/reports/Request.jasper";
    private static final String TOP_PROVIDERS_REPORT = "src/main/resources/reports/TopProviders.jasper";
    private static final String TOP_PURCHASES_REPORT = "src/main/resources/reports/TopPurchases.jasper";

    @GetMapping("/providers")
    public ResponseEntity<byte[]> generateProvidersReport() throws Exception {
        Map<String, Object> params = new HashMap<>();
        Connection conn = getConnection();
        params.put("REPORT_CONNECTION", conn);
        JasperPrint jasperPrint = JasperFillManager.fillReport(PROVIDERS_REPORT, params, conn);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "providers.pdf");
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<byte[]> generateRequestReport(@PathVariable Integer id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        Connection conn = getConnection();
        params.put("REPORT_CONNECTION", conn);
        params.put("ID_PROVIDER", id);
        JasperPrint jasperPrint = JasperFillManager.fillReport(REQUEST_REPORT, params, conn);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Request.pdf");
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/providers/top")
    public ResponseEntity<byte[]> generateProvidersTopReport() throws Exception {
        Map<String, Object> params = new HashMap<>();
        Connection conn = getConnection();
        params.put("REPORT_CONNECTION", conn);
        JasperPrint jasperPrint = JasperFillManager.fillReport(TOP_PROVIDERS_REPORT, params, conn);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "TopProviders.pdf");
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/purchases/top")
    public ResponseEntity<byte[]> generatePurchasesTopReport() throws Exception {
        Map<String, Object> params = new HashMap<>();
        Connection conn = getConnection();
        params.put("REPORT_CONNECTION", conn);
        params.put("ID_PROVIDER", 5);
        JasperPrint jasperPrint = JasperFillManager.fillReport(TOP_PURCHASES_REPORT, params, conn);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "TopPurchases.pdf");
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "alessandro";
        return DriverManager.getConnection(url, user, password);
    }
}
