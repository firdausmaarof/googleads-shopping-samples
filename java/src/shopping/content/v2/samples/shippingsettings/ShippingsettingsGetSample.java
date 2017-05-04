package shopping.content.v2.samples.shippingsettings;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.content.model.ShippingSettings;
import java.io.IOException;
import org.apache.commons.cli.ParseException;
import shopping.content.v2.samples.ContentSample;

/** Sample that retrieves the shipping settings for the current Merchant Center account. */
public class ShippingsettingsGetSample extends ContentSample {
  public ShippingsettingsGetSample(String[] args) throws IOException, ParseException {
    super(args);
  }

  @Override
  public void execute() throws IOException {
    try {
      ShippingSettings settings =
          content.shippingsettings().get(config.getMerchantId(), config.getMerchantId()).execute();
      ShippingsettingsUtils.printShippingSettings(settings);
    } catch (GoogleJsonResponseException e) {
      checkGoogleJsonResponseException(e);
    }
  }

  public static void main(String[] args) throws IOException, ParseException {
    new ShippingsettingsGetSample(args).execute();
  }
}
