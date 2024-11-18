import React, { useState, useEffect } from 'react';

const MusicSet = () => {
    const [musicSets, setMusicSets] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/music-set')
            .then((response) => response.json())
            .then((data) => setMusicSets(data));
    }, []);

    const makeMusicSet = () => {
        const data = {
            title: 'test-music-set-title2',
            composer: 'test-music-set-composer2',
            arranger: 'test-music-set-arranger2',
            forTrainingBand: true,
        };

        fetch('http://localhost:8080/api/music-set', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((data) => alert('Music set created'));
    };

    return (
        <div>
            <h3>Music Sets</h3>
            <ul>
                {musicSets.map((set) => (
                    <li key={set.id}>{set.title}</li>
                ))}
            </ul>
            <button onClick={makeMusicSet}>Make Music Set</button>
        </div>
    );
};

export default MusicSet;
