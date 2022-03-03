package com.shahid.mercans.assignment2.parser.csvparser;

/**
 * Factory class for request handler, responsible to make request handler object as per input
 * @author Shahid Farooq
 *
 */
public class RequestHandlerFactory {

	public IParserRequestHandler getRequestHandler(String requestIdentifier) {
		if (requestIdentifier.equalsIgnoreCase("hire"))
			return new HireRequestHandler();
		else if (requestIdentifier.equalsIgnoreCase("change"))
			return new ChangeRequestHandler();
		else if (requestIdentifier.equalsIgnoreCase("terminate"))
			return new TerminateRequestHandler();
		return null;
	}

}
