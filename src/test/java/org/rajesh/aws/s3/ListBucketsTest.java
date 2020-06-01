package org.rajesh.aws.s3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListBucketsTest {

    private ListBuckets listBuckets;

    @BeforeEach
    void setUp() {
        listBuckets = new ListBuckets();
    }

    @Test
    @DisplayName("This test assumes you have at least one bucket in your aws account")
    void getBuckets() {
        final List<String> buckets = listBuckets.getBuckets();
        Assertions.assertNotEquals(0, buckets.size());
    }

    @Test
    void getBucketPolicy() {
        final String bucketPolicy = listBuckets.getBucketPolicy("udagram-dwivedi-dev");
    }
}