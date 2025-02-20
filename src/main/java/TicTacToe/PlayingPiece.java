package TicTacToe;

public class PlayingPiece {
    PieceType pieceType;
    PlayingPiece(PieceType pieceType){
        this.pieceType=pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PlayingPiece that = (PlayingPiece) obj;
        return pieceType == that.pieceType;
    }

    @Override
    public int hashCode() {
        return pieceType.hashCode();
    }
}
