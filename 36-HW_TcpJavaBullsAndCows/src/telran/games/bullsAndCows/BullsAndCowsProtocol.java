package telran.games.bullsAndCows;

import telran.net.*;

import telran.net.server.*;

public class BullsAndCowsProtocol implements ProtocolJava {
	BullsCowsGameImpl game = new BullsCowsGameImpl();

	@Override
	public ResponseJava getResponse(RequestJava request) {
		try {
			switch (request.requestType) {
			case "start": {
				return new ResponseJava(TcpResponseCode.OK, (String) (game.startGame()));
			}
			case "move":{
				if(game.isFinished()||!game.isStarted()) {
					return new ResponseJava(TcpResponseCode.OK, (String) game.prompt());
				}
				return new ResponseJava(TcpResponseCode.OK, (String) game.move((String) request.requestData));
			}
				
			default:
				throw new Exception("Unknown Request " + request.requestType);
			}
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}

	}

}
