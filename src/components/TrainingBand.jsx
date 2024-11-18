import React, { useState, useEffect } from 'react';

const TrainingBand = () => {
  const [trainingBands, setTrainingBands] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/training-band')
      .then((response) => response.json())
      .then((data) => setTrainingBands(data));
  }, []);

  const makeTrainingBand = () => {
    const data = { name: 'test-training-band' };

    fetch('http://localhost:8080/api/training-band', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => alert('Training band created'));
  };

  return (
    <div>
      <h3>Training Bands</h3>
      <ul>
        {trainingBands.map((band) => (
          <li key={band.id}>{band.name}</li>
        ))}
      </ul>
      <button onClick={makeTrainingBand}>Make Training Band</button>
    </div>
  );
};

export default TrainingBand;
