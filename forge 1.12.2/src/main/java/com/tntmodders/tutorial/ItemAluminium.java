package com.tntmodders.tutorial;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemAluminium extends Item {

    public ItemAluminium() {
        super();

        this.setCreativeTab(CreativeTabs.MATERIALS);
        
    }
    
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);



//ExplosionのEntity(現plyer)は爆発の核になる？（playerじゃ爆発しない
//クリック位置に適当なEntityを召喚してから爆発させる？
		//Explosionを継承して、Entityの必要ないクラスを作る！？
		
			Explosion exp=new Explosion(world,player,hitX,hitY,hitZ,3F,true,true);
			exp.doExplosionA();
			exp.doExplosionB(true);
			
			

		return EnumActionResult.SUCCESS;
	}
	
	
	
	/**
	 * Entityを殴ったときの攻撃力と攻撃速度を変更する。<br>
	 * Entityのステータス変更はAttributeModifierというものを使用する。<br>
	 * ちなみに、AttributeModifierを自作してオリジナルのステータス変化を作ることもできる。
	 *
	 * @return AttributeModifiersの設定を入れたMultiMap
	 * @param slot アイテムが装備されているスロット
	 * @param stack 対象のアイテム
	 */
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

		// メインハンドの時のみ
		if (slot == EntityEquipmentSlot.MAINHAND) {
			// 攻撃力
			// 数値(10.0F)以外は固定なのでそのままコピペで使用すると楽
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
					new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 10.0F, 0));
			// 攻撃速度
			// 数値(-2.5DF)以外は固定
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
					new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.5D, 0));
		}

		return multimap;
	}
}