package domain

class Tile(_status: TileStatus) {
    var status = _status
        private set

    fun changeStatus(newStatus: TileStatus) {
        this.status = newStatus
    }

    fun openTile() {
        if (this.status != TileStatus.NORMAL) {
            throw IllegalArgumentException("Tile should not be opened!")
        }
        this.status = TileStatus.OPEN
    }
}