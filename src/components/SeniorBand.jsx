import React, { useState, useEffect } from 'react';

const SeniorBand = () => {
  const [seniorBands, setSeniorBands] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/senior-band')
      .then((response) => response.json())
      .then((data) => setSeniorBands(data));
  }, []);

  const makeSeniorBand = () => {
    const data = { name: 'test-senior-band' };

    fetch('http://localhost:8080/api/senior-band', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => alert('Senior band created'));
  };

  return (
    <div>
      <h3>Senior Bands</h3>
      <ul>
        {seniorBands.map((band) => (
          <li key={band.id}>{band.name}</li>
        ))}
      </ul>
      <button onClick={makeSeniorBand}>Make Senior Band</button>
    </div>
  );
};

export default SeniorBand;
