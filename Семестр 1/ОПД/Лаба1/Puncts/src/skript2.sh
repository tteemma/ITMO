#!/bin/bash

mkdir "lab0"
cd lab0

mkdir -p charmander1/octillery charmander1/empoleon charmander1/krabby jigglypuff0/ampharos jigglypuff0/rattata jigglypuff0/ursaring jigglypuff0/gyarados jigglypuff0/cofagrigus jigglypuff0/Stoutland tynamo2/haunter tynamo2/cleffa tynamo2/skitty tynamo2/sudowoodo tynamo2/golduck
echo -e "Тип покемона ROCK FLYING"> archeops4
echo -e "Способности Tackle Morning Sun Growth Leech Seed Helping Hand Magical Leaf Sunny Day Worry Seed Take Down Solarbeam
Lucky Chant"> cherubi3
echo -e "Способности Quick Attack Focus Energy Bite Pursuit Hyper Fang Sucker Punch Scary Face Crunch Assurance Super Fang
Double-Edge Endeavor"> raticatel
cat > beheeyem << EOF
Block Miracle Eye Psybeam Headbutt Hidden Powr Imprison Simple Beam
Zen Headbutt Psych Up Psychic Calm Mind Recovaer Guard Split Power Split Synchronoise Wonder Room
EOF
cat > poliwhirl << EOF
Тип покемона WATER
NONE
EOF

mv beheeyem charmander1
mv poliwhirl charmander1

chmod 640 archeops4
chmod 555 charmander1
cd charmander1
chmod 733 empoleon
chmod 400 beheeyem
chmod 064 poliwhirl
cd ..
chmod 611 cherubi3
chmod 311 jigglypuff0
cd jigglypuff0
chmod 524 ampharos
chmod 357 rattata
chmod 666 ursaring
chmod 570 gyarados
chmod 767 cofagrigus
chmod 733 Stoutland
cd ..
mv raticatel raticate1
chmod 404 raticate1
chmod 571 tynamo2
cd tynamo2
chmod 513 haunter
chmod 573 cleffa
chmod 676 skitty
chmod 357 sudowoodo
chmod 555 golduck
cd ..
