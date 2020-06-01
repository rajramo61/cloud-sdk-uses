package org.rajesh.aws.s3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessCsvTest {
    private ProcessCsv processCsv;

    @BeforeEach
    void setUp() throws IOException {
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        processCsv = new ProcessCsv(absolutePath + "/test.csv");
    }

    @Test
    void readCsvFile() throws IOException {
        List<String> columns = Arrays.asList("policyID", "county", "eq_site_deductible", "line", "point_granularity");
        processCsv.readCsvFile(columns);
    }
}