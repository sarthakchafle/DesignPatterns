package ChessDesign;

public class King extends Piece{
    public King(boolean isWhitePiece, MovementStrategy movementStrategy) {
        super(isWhitePiece, new KingMovementStrategy());
    }
}
