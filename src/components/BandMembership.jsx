import React, { useState, useEffect } from 'react';

const BandMembership = () => {
  const [bandMemberships, setBandMemberships] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/band-membership')
      .then((response) => response.json())
      .then((data) => setBandMemberships(data));
  }, []);

  const makeBandMembership = () => {
    const data = {
      seniorBandId: 1,
      trainingBandId: 1,
      memberId: 65,
    };

    fetch('http://localhost:8080/api/band-membership', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => alert('Band membership created'));
  };

  const deleteBandMembership = (id) => {
    fetch(`http://localhost:8080/api/band-membership/${id}`, {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        firstName: 'Connor',
        lastName: 'Silvester',
        email: 'connorsilvester@gmail.com',
        phoneNumber: '12345678910',
        password: 'test',
      }),
    })
      .then(() => alert('Band membership deleted'));
  };

  return (
    <div>
      <h3>Band Memberships</h3>
      <ul>
        {bandMemberships.map((item) => (
          <li key={item.id}>
            {item.name} <button onClick={() => deleteBandMembership(item.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <button onClick={makeBandMembership}>Make Band Membership</button>
    </div>
  );
};

export default BandMembership;
