package org.rajesh.aws.s3;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ListBuckets {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListBuckets.class);
    List<String> getBuckets() {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
        List<Bucket> buckets = s3.listBuckets();

        //Using peek is not required. I just added to do a quick peek in the logs when I run the tests.
        return buckets.stream()
                .map(Bucket::getName)
                .peek(bName -> LOGGER.info("Bucket Name {}", bName))
                .collect(toList());
    }
}
