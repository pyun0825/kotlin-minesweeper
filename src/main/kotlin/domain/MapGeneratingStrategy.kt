package domain

interface MapGeneratingStrategy {
    fun generateMap(width: Width, height: Height, mineCount: MineCount): ArrayList<List<Tile>>
}
