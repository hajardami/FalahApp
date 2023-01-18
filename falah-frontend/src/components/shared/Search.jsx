import React from "react";
import InputBase from '@mui/material/InputBase';
import Paper from "@mui/material/Paper";
import SearchIcon from '@mui/icons-material/Search';
import IconButton from '@mui/material/IconButton';

const Search = () => {
    let [search, setSearch] = React.useState('');
    return (
        <Paper
        component="form"
        sx={{ p: "2px 4px",ml: 2, display: "flex", alignItems: "center", width: 600, height: 30 ,backgroundColor:"#464945"}}
      >
        <InputBase
          sx={{ ml: 1, flex: 1 }}
          type='text'
          placeholder="Search..."
          inputProps={{ "aria-label": "search" }}
          onChange={
              event=>{
            setSearch(event.target.value)
            }
          }
   style={{color:"white" }}
        />
        <IconButton    type="submit" sx={{ p: "10px" }} aria-label="search"    style={{color:"white" }}>
          <SearchIcon  onClick={() => { /*here to insert serching traitement it depends on the backend */}} />
        </IconButton>
      </Paper>
    );
};

export default Search;