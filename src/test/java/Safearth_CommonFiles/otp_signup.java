package Safearth_CommonFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import javax.mail.Message;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import io.grpc.Status.Code;

public class otp_signup {
public class Apptest{
	public void testMailExample() throws IOException, MailosaurException{
		String apiKey = "AFEXODbc6fUxgUBmkLfgwCgyeA89oPJu";
	    String serverId = "nqd8vx3q";
	    String serverDomain = "nqd8vx3q.mailosaur.net";
	    MailosaurClient mailosaur = new MailosaurClient(apiKey);

	    MessageSearchParams params = new MessageSearchParams();
	    params.withServer(serverId);

	    SearchCriteria criteria = new SearchCriteria();
	    criteria.withSentTo("practical-thou@" + serverDomain);
	    com.mailosaur.models.Message message = mailosaur.messages().get(params, criteria);

	    assertNotNull(message);
	    assertEquals("My email subject", message.subject());
	 // How many codes?
	    System.out.println(message.html().codes().size()); // 2

	    com.mailosaur.models.Code firstCode = message.html().codes().get(0);
	    System.out.println(firstCode.value());
	}
}
}
