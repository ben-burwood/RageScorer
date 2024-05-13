# Rage Scorer

Scoring app for the Card Game 'Rage' using Kotlin and Compose Multiplatform, targting Android, iOS,
Desktop and Web.

## Rage

https://en.wikipedia.org/wiki/Rage_(trick-taking_card_game)

### Rules

- +1 Point for each trick
- +10 Points for taking exactly the number of tricks bid
    - Only +5 are awarded if the player bid and took zero tricks.

To this, the Bonus Rage and Mad Rage points are added or subtracted (+5 for Bonus Rage, -5 for Mad
Rage).
Bonuses and penalties stack, so if a player takes two Bonus Rage cards they earn 10 extra points; if
a player takes a Bonus Rage and a Mad Rage card, the bonus and penalty net to zero.