/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aws_startstop;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import static com.amazonaws.services.ec2.AmazonEC2ClientBuilder.standard;
import com.amazonaws.services.ec2.model.DryRunResult;
import com.amazonaws.services.ec2.model.DryRunSupportedRequest;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import java.util.Scanner;

/**
 *
 * @author sunayanasattaru
 */

public class StartStopInstance {
    public static void startInstance(String instance_id) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("ABC", "XYZ");
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .withRegion(Regions.US_EAST_1)
                        .build();

        StartInstancesRequest request = new StartInstancesRequest()
            .withInstanceIds(instance_id);

        ec2.startInstances(request);

        System.out.printf("Successfully started instance %s", instance_id);
    }

    public static void stopInstance(String instance_id) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("ABC", "XYZ");
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .withRegion(Regions.US_EAST_1)
                        .build();

        StopInstancesRequest request = new StopInstancesRequest()
            .withInstanceIds(instance_id);

        ec2.stopInstances(request);

        System.out.printf("Successfully stop instance %s", instance_id);
    }
    
    public static void main(String[] args) {
        final String USAGE =
            "To run this example, supply an instance id and start or stop\n" +
            "Ex: StartStopInstance <instance-id> <start|stop>\n";

        Scanner input = new Scanner(System.in);
        System.out.println("Enter instance_id: ");
        String instance_id = input.nextLine();  
        
        System.out.println("Enter true or false to start instance_id:");
        boolean startStop = input.nextBoolean();
                        
        // false = stop instance & true = start        
        if(startStop == true) {
            startInstance(instance_id);
        } else {
            stopInstance(instance_id);
        }
    }
}