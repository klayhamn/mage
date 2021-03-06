/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.khansoftarkir;

import java.util.UUID;
import mage.abilities.condition.LockedInCondition;
import mage.abilities.condition.common.FerociousCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.common.combat.MustBeBlockedByAllTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.IndestructibleAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class RoarOfChallenge extends CardImpl {

    public RoarOfChallenge(UUID ownerId) {
        super(ownerId, 145, "Roar of Challenge", Rarity.UNCOMMON, new CardType[]{CardType.SORCERY}, "{2}{G}");
        this.expansionSetCode = "KTK";


        // All creatures able to block target creature this turn do so.
        this.getSpellAbility().addEffect(new MustBeBlockedByAllTargetEffect(Duration.EndOfTurn));
        // <i>Ferocious</i> - That creature gains indestructible until end of turn if you control a creature with power 4 or greater.
        this.getSpellAbility().addEffect(new ConditionalContinuousEffect(
                new GainAbilityTargetEffect(IndestructibleAbility.getInstance(), Duration.EndOfTurn),
                new LockedInCondition(FerociousCondition.getInstance()),
                "<br><i>Ferocious</i> &mdash; That creature gains indestructible until end of turn if you control a creature with power 4 or greater."));
        this.getSpellAbility().addTarget(new TargetCreaturePermanent());
    }

    public RoarOfChallenge(final RoarOfChallenge card) {
        super(card);
    }

    @Override
    public RoarOfChallenge copy() {
        return new RoarOfChallenge(this);
    }
}
