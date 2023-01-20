import React, { useState } from 'react';
import {Button, Dialog,  DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions, ThemeProvider} from '@mui/material'
import { addNewsService } from '../../service/nouveautes';

const AddNewsDialog = (props) => {

    const [successful, setSuccessful] = useState(false);

    const handleSubmit = (event) => {

        addNewsService(event,setSuccessful);
    
        props.handleClose()
    };

    return (
        <div>
      <Dialog open={props.open} onClose={props.handlecolse}>
        <DialogTitle>Ajouter une nouveauté</DialogTitle>
        <DialogContent>
        <form id="my-form-id" onSubmit={handleSubmit}>
          <TextField
            autoFocus
            margin="dense"
            id="title"
            name="title"
            label="Titre"
            fullWidth
            variant="outlined"
          />

          <TextField
            autoFocus
            margin="dense"
            id="description"
            name="description"
            label="Description"
            multiline
            rows={4}
            fullWidth
            variant="outlined"
          />

          
            <div>Télécharger une image</div>
                        <input
                          className="form-control"
                          type="file"
                          id="image"
                          name="image"
                          accept="image/*,application/pdf"
                        />
        </form>
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} >Annuler</Button>
          <Button type="submit" form="my-form-id" variant="contained">Publier</Button>
        </DialogActions>
      </Dialog>
    </div>
    );
};

export default AddNewsDialog;