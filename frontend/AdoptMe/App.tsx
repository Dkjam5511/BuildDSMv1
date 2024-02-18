import React, { useEffect, useRef, useState } from 'react';
import { ActivityIndicator, Button, ImageBackground, StyleSheet, Text, View } from 'react-native';
import Swiper from 'react-native-deck-swiper';

interface Card {
  name: string;
  breed: string;
  age: number;
  description: string;
  traits: string[];
}

const App: React.FC = () => {
  const [cards, setCards] = useState<Card[]>([]);
  const [loading, setLoading] = useState(true);
  const [allSwiped, setAllSwiped] = useState(false);
  const [leftSwiped, setLeftSwiped] = useState(false);
  const [rightSwiped, setRightSwiped] = useState(false);

  useEffect(() => {
    setCards([
      { name: 'Betsy', breed: 'Golden Retriever', age: 3, description: 'Betsy is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
      { name: 'Fido', breed: 'Golden Retriever', age: 3, description: 'Fido is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
      { name: 'Rupert', breed: 'Golden Retriever', age: 3, description: 'Rupert is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
      { name: 'Blueberry', breed: 'Golden Retriever', age: 3, description: 'Blueberry is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
      { name: 'Ruckus', breed: 'Golden Retriever', age: 3, description: 'Ruckus is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
      { name: 'Orange', breed: 'Golden Retriever', age: 3, description: 'Orange is a very friendly dog who loves to play and go for walks.', traits: ['friendly', 'playful', 'energetic'] },
    ]);
    setLoading(false);
  }, []);

  if (loading) {
    return <ActivityIndicator size="large" color="#0000ff" />;
  }

  return (
    <View style={styles.container}>
      <Swiper
        cards={cards}
        renderCard={(card) => {
          return (
              <ImageBackground source={require('./assets/dog.png')} style={styles.card}>
              {rightSwiped && <Text style={styles.like}>Like</Text>}
              {leftSwiped && <Text style={styles.dislike}>Dislike</Text>}
                <Text style={styles.name}>{card.name}</Text>
                <View style={styles.row}>
                  <Text style={styles.breed}>{card.breed}</Text>
                  <Text style={styles.age}>Age: {card.age}</Text>
                </View>
                <Text style={styles.description}>{card.description}</Text>
                <Text style={styles.traits}>{card.traits.join(', ')}</Text>
              </ImageBackground>
          )
        }}
        onSwipedLeft={(cardIndex) => {
          setLeftSwiped(true); setTimeout(() => {
            setLeftSwiped(false);
          }, 500); console.log(cardIndex + " swiped left")
        }}
        onSwipedRight={(cardIndex) => {
          setRightSwiped(true);
          setTimeout(() => {
            setRightSwiped(false);
          }, 500);
          console.log(cardIndex + " swiped right")
        }}
        onSwipedAll={() => { setAllSwiped(true); console.log('onSwipedAll') }}
        cardIndex={0}
        backgroundColor={'#262a2b'}
        stackSize={3}
        disableBottomSwipe={true}
        disableTopSwipe={true}>
      </Swiper>
      {allSwiped && <Text style={styles.name}>No more dogs D:</Text>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'flex-start',
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  card: {
    flex: 1,
    borderRadius: 4,
    borderWidth: 2,
    borderColor: '#E8E8E8',
    justifyContent: 'flex-end',
    padding: 20,
  },
  name: {
    fontSize: 30,
    fontWeight: 'bold',
    textAlign: 'left',
  },
  breed: {
    fontSize: 20,
    textAlign: 'left',
    marginTop: 10,
  },
  age: {
    fontSize: 15,
    textAlign: 'right',
    marginTop: 10,
  },
  description: {
    fontSize: 15,
    textAlign: 'left',
    marginTop: 10,
  },
  traits: {
    fontSize: 15,
    textAlign: 'left',
    marginTop: 10,
  },
  like: {
    position: 'absolute',
    top: 20,
    right: 20,
    textAlign: 'center',
    fontSize: 30,
    fontWeight: 'bold',
    color: 'green',
    backgroundColor: 'white',
    padding: 10,
    borderWidth: 2,
    borderRadius: 10,
    borderColor: 'green',
  },
  dislike: {
    position: 'absolute',
    top: 20,
    left: 20,
    textAlign: 'center',
    fontSize: 30,
    fontWeight: 'bold',
    color: 'red',
    backgroundColor: 'white',
    padding: 10,
    borderWidth: 2,
    borderRadius: 10,
    borderColor: 'red',
  },
});

export default App;