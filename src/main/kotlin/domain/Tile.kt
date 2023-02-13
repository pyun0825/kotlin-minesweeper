package domain

class Tile(_status: TileStatus) {
    var status = _status
        private set

    fun changeStatus(newStatus: TileStatus) {
        this.status = newStatus
    }
}