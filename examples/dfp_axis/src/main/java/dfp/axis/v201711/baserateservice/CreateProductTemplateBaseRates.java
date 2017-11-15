// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dfp.axis.v201711.baserateservice;

import com.beust.jcommander.Parameter;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.utils.examples.CodeSampleParams;
import com.google.api.ads.dfp.axis.factory.DfpServices;
import com.google.api.ads.dfp.axis.v201711.BaseRate;
import com.google.api.ads.dfp.axis.v201711.BaseRateServiceInterface;
import com.google.api.ads.dfp.axis.v201711.Money;
import com.google.api.ads.dfp.axis.v201711.ProductTemplateBaseRate;
import com.google.api.ads.dfp.lib.client.DfpSession;
import com.google.api.ads.dfp.lib.utils.examples.ArgumentNames;
import com.google.api.client.auth.oauth2.Credential;

/**
 * This example creates a product template base rate. To determine which base rates exist,
 * run GetAllBaseRates.java.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class CreateProductTemplateBaseRates {

  private static class CreateProductTemplateBaseRatesParams extends CodeSampleParams {
    @Parameter(names = ArgumentNames.RATE_CARD_ID, required = true,
        description = "The rate card ID to add the base rate to.")
    private Long rateCardId;

    @Parameter(names = ArgumentNames.PRODUCT_TEMPLATE_ID, required = true,
        description = "The product template to apply this base rate to.")
    private Long productTemplateId;
  }

  public static void runExample(DfpServices dfpServices, DfpSession session, long rateCardId,
      long productTemplateId)
      throws Exception {
    // Get the BaseRateService.
    BaseRateServiceInterface baseRateService =
        dfpServices.get(session, BaseRateServiceInterface.class);

    // Create a base rate for a product template.
    ProductTemplateBaseRate productTemplateBaseRate = new ProductTemplateBaseRate();

    // Set the rate card ID that the product template base rate belongs to.
    productTemplateBaseRate.setRateCardId(rateCardId);

    // Set the product template the base rate will be applied to.
    productTemplateBaseRate.setProductTemplateId(productTemplateId);

    // Create a rate worth $2 and set that on the product template base rate.
    Money rate = new Money();
    rate.setCurrencyCode("USD");
    rate.setMicroAmount(2000000L);
    productTemplateBaseRate.setRate(rate);

    // Create the product template base rate on the server.
    BaseRate[] baseRates = baseRateService.createBaseRates(
        new BaseRate[] {productTemplateBaseRate});

    for (BaseRate createdBaseRate : baseRates) {
      System.out.printf("A product template base rate with ID %d and rate %.4f %s "
          + "was created.%n", createdBaseRate.getId(),
          (((ProductTemplateBaseRate) createdBaseRate).getRate().getMicroAmount() / 1000000f),
          ((ProductTemplateBaseRate) createdBaseRate).getRate().getCurrencyCode());
    }
  }

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.DFP)
        .fromFile()
        .build()
        .generateCredential();

    // Construct a DfpSession.
    DfpSession session = new DfpSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    DfpServices dfpServices = new DfpServices();

    CreateProductTemplateBaseRatesParams params = new CreateProductTemplateBaseRatesParams();
    if (!params.parseArguments(args)) {
      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.rateCardId = Long.parseLong("INSERT_RATE_CARD_ID_HERE");
      params.productTemplateId = Long.parseLong("INSERT_PRODUCT_TEMPLATE_ID_HERE");
    }

    runExample(dfpServices, session, params.rateCardId, params.productTemplateId);
  }
}
