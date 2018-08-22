package hurts.metallurgy_5.util;

import java.util.List;

import hurts.metallurgy_5.Metallurgy_5;
import hurts.metallurgy_5.armor.ModArmor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber(modid=Metallurgy_5.MODID)
public class EventHandler {

	@SubscribeEvent
	public static void checkEntity(PlayerTickEvent event) {
		int radius=32, max=0;
		boolean isArmored=false;

		System.out.println("EventHandler");

		if (event.player.inventory.armorItemInSlot(3).getItem() == ModArmor.mithril_helmet
			&&event.player.inventory.armorItemInSlot(2).getItem() == ModArmor.mithril_chest
			&&event.player.inventory.armorItemInSlot(1).getItem() == ModArmor.mithril_legs
			&&event.player.inventory.armorItemInSlot(0).getItem() == ModArmor.mithril_boots){
				System.out.println("Entrato in IF");
				isArmored=true;
		}

		double xM = event.player.posX + radius, yM = event.player.posY + radius, zM = event.player.posZ + radius; //Definiamo il Massimo di X Y Z
		double xm = event.player.posX - radius, ym = event.player.posY - radius, zm = event.player.posZ - radius; //Definiamo il minimo di X Y Z
		List <Entity> list;	//Creazione lista

		list = event.player.getEntityWorld().getEntitiesWithinAABBExcludingEntity(event.player,new AxisAlignedBB(xM, yM, zM, xm, ym, zm));//Immetiamo in lista tutte le entit� comprese da il minimo e massimo di X Y Z
		Entity a[] = new Entity [list.size()]; // Creiamo un array di entity grande quanto la lista

		for(int i=0; i<list.size();i++) {	// For con controllo se si indossa l'armatura e se i< della grandezza della lista
			max=i;                   //Inseriamo il valore di "I" a singola ripetizione in max
			list.toArray(a);				// Inseriamo il contenuto della lista nell'array "a"
			a[i].setGlowing(isArmored);//Le entità di a che si trovano in posizione "i" riceveranno l'effetto glowing
			for(int k=0;k<=max;k++) {  //per k=0 fino a che k non è <= del massimo della n ripetizione
				if(a[k].getDistance(event.player) > radius) { //controllo fra entità in posizione k e player
					a[k].setGlowing(false); // Rimuoviamo l'effetto Glowing all'entità in posizione "k" di "a"
				}
			}
		}
	}

//	@SubscribeEvent
//	 public static void isPlayerAttacked(PlayerTickEvent event, boolean isArmorEquipped, LivingHurtEvent b) {
//		float damage = 0 ;
//		if(b.getEntity()==event.player) {
//			damage = b.getAmount();
//		}
//
//
//		EntityLivingBase target = event.player.getAttackingEntity();
//
//		float playerHP = event.player.getHealth(),HP= playerHP-damage;
//		System.out.println(playerHP+" "+HP);
//
//		if(target != null && isArmorEquipped && playerHP>HP) {
//			System.out.println("entrato");
//			event.player.getAttackingEntity().addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE,20,0));
//
//			target=null;
//			damage = 0;
//		}
//	 }
}