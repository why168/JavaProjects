package examples

/**
 * 小头爸爸
 *
 * @author Edwin.Wu
 * @version 2018/2/8 下午6:51
 * @since JDK1.8
 */
class SmallHeadFather : IWashBowl by BigHeadSon {
    override fun washing() {
        println("我是小头爸爸，我赚了10块钱")
        BigHeadSon.washing()
        println("我是看这儿子把碗洗完了")
    }

}