# Recommend API SDK

This is SDK for connecting with [Recommend, Inc. platform](https://www.recommend.co/). If you need any support contact support@recommend.co

# Using the SDK

First, you need to obtain your API key [here](https://www.recommend.co/partners/api-keys).  When you have obtained your API key, you can use our SDK built from source here (from master branch). We have other integration options too - for details, please check our [developer documentation](https://about.recommend.co/api-docs/).

## Initializing SDK

### When you have added package reference, you can initialize the SDK like this:

    SDK sdk = new SDK("your-api-key", "");

### You can test connection to our platform like this:

    boolean result = sdk.TestConnection();

### To send us referral information, when conversion occurs, send it like this:

    sdk.ReferralCheck("referralCode", "", "", "", "");

Parameters for conversion are referral code, email (optional), phone number (optional), order number (optional) and cart total (optional).

### Conversions can be approved using API from your application using following call:

    sdk.ApproveConversion(conversionIdYouReceivedInReferralCheckResponse);

### Or you can reject conversion:

    sdk.RejectConversion(conversionIdYouReceivedInReferralCheckResponse)